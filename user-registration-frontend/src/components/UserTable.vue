<template>
  <div class="card">
    <h2>All Registered Users</h2>

    <table v-if="users.length > 0">
      <thead>
        <tr>
          <th>Full Name</th>
          <th>Email</th>
          <th>Mobile</th>
          <th>DOB</th>
          <th>Actions</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="u in users" :key="u.id || u._id">
          <td>{{ u.fullName }}</td>
          <td>{{ u.email }}</td>
          <td>{{ u.mobileNumber }}</td>
          <td>{{ u.dob || "-" }}</td>
          <td>
            <button class="btn edit" @click="$emit('editUser', u)">Edit</button>

            <button
              class="btn delete"
              @click="$emit('deleteUser', u.id || u._id)"
            >
              Delete
            </button>
          </td>
        </tr>
      </tbody>
    </table>

    <p v-else class="empty">No users found.</p>
  </div>
</template>

<script>
export default {
  props: {
    users: Array,
  },
};
</script>

<style scoped>
.card {
  width: 700px;
  background: #fff;
  border: 1px solid #e6e6e6;
  padding: 18px;
  border-radius: 12px;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 12px;
}

th,
td {
  border: 1px solid #cfcfcf;
  padding: 10px;
  text-align: left;
}

.btn {
  padding: 6px 12px;
  border-radius: 7px;
  border: none;
  cursor: pointer;
  margin-right: 8px;
}

.edit {
  background: #43a047;
  color: white;
}

.delete {
  background: #e53935;
  color: white;
}

.empty {
  margin-top: 12px;
}
</style>
