<template>
  <div class="main">
    <UserForm
      :selectedUser="selectedUser"
      @submitForm="submitForm"
      @cancelEdit="cancelEdit"
    />

    <UserTable
      :users="users"
      @editUser="editUser"
      @deleteUser="deleteUser"
    />
  </div>
</template>

<script>
import UserForm from "../components/UserForm.vue";
import UserTable from "../components/UserTable.vue";

import {
  createUser,
  getAllUsers,
  updateUser,
  deleteUser,
} from "../api/userService";

export default {
  components: { UserForm, UserTable },

  data() {
    return {
      users: [],
      selectedUser: null,
    };
  },

  mounted() {
    this.fetchUsers();
  },

  methods: {
    async fetchUsers() {
      try {
        const res = await getAllUsers();
        this.users = res.data;
      } catch (e) {
        console.log("Fetch users failed:", e);
        alert("Backend connect nahi ho raha ");
      }
    },

    editUser(user) {
      this.selectedUser = {
        id: user.id || user._id,
        fullName: user.fullName,
        email: user.email,
        mobileNumber: user.mobileNumber,
        password: user.password,
        dob: user.dob,
      };
    },

    cancelEdit() {
      this.selectedUser = null;
    },

    async submitForm(formData) {
      console.log("Submit formData =>", formData);

      try {
        if (formData.id) {
          console.log("Calling UPDATE API with id:", formData.id);

          const res = await updateUser(formData.id, formData);
          console.log("UPDATE RESPONSE =>", res.data);

          alert("User Updated ");
        } else {
          console.log("Calling CREATE API");

          const res = await createUser(formData);
          console.log("CREATE RESPONSE =>", res.data);

          alert("User Registered ");
        }

        this.selectedUser = null;
        await this.fetchUsers();
      } catch (e) {
        console.log("FULL ERROR =>", e);

        if (e.response) {
          console.log("STATUS =>", e.response.status);
          console.log("DATA =>", e.response.data);
          console.log("HEADERS =>", e.response.headers);

          alert(
            "API Error: " +
              (e.response.data?.message ||
                JSON.stringify(e.response.data) ||
                "Unknown backend error")
          );
        } else {
          alert("Network/JS Error: " + e.message);
        }
      }
    },

    async deleteUser(id) {
      const ok = confirm("Are you sure you want to delete?");
      if (!ok) return;

      try {
        await deleteUser(id);
        alert("User Deleted ");
        await this.fetchUsers();
      } catch (e) {
        console.log("DELETE ERROR =>", e);
        alert("Delete failed ");
      }
    },
  },
};
</script>

<style scoped>
.main {
  display: flex;
  gap: 20px;
  padding: 25px;
  background: #f5f5f5;
  min-height: 100vh;
  justify-content: center;
  align-items: flex-start;
}
</style>
