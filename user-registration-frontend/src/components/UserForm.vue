<template>
  <div class="card">
    <h2>{{ isEdit ? "Update User" : "Register User" }}</h2>

    <form @submit.prevent="handleSubmit">
      <!-- Full Name -->
      <div class="field">
        <label>Full Name <span class="req">*</span></label>
        <input v-model="form.fullName" type="text" placeholder="Enter full name" />
        <p class="error" v-if="errors.fullName">{{ errors.fullName }}</p>
      </div>

      <!-- Email -->
      <div class="field">
        <label>Email <span class="req">*</span></label>
        <input v-model="form.email" type="text" placeholder="Enter email" />
        <p class="error" v-if="errors.email">{{ errors.email }}</p>
      </div>

      <!-- Mobile -->
      <div class="field">
        <label>Mobile Number <span class="req">*</span></label>
        <input
          v-model="form.mobileNumber"
          type="text"
          placeholder="Enter mobile number"
        />
        <p class="error" v-if="errors.mobile">{{ errors.mobile }}</p>
      </div>

      <!-- Password -->
      <div class="field">
        <label>Password <span class="req">*</span></label>
        <input v-model="form.password" type="password" placeholder="Enter password" />
        <p class="error" v-if="errors.password">{{ errors.password }}</p>
      </div>

      <!-- DOB -->
      <div class="field">
        <label>Date of Birth (Optional)</label>
        <input v-model="form.dob" type="date" />
      </div>

      <div class="btns">
        <button class="btn primary" type="submit">
          {{ isEdit ? "Update" : "Register" }}
        </button>

        <button v-if="isEdit" class="btn gray" type="button" @click="resetForm">
          Cancel
        </button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  props: {
    selectedUser: Object,
  },

  data() {
    return {
      form: {
        id: null,
        fullName: "",
        email: "",
        mobileNumber: "",
        password: "",
        dob: "",
      },
      errors: {},
    };
  },

  computed: {
    isEdit() {
      return this.form.id !== null;
    },
  },

  watch: {
    selectedUser: {
      immediate: true,
      handler(user) {
        if (user) {
          this.form = { ...user };
        }
      },
    },
  },

  methods: {
    validateForm() {
      this.errors = {};
      let valid = true;
      
      if (!this.form.fullName.trim()) {
        this.errors.fullName = "Full Name is required";
        valid = false;
      }

      if (!this.form.email.trim()) {
        this.errors.email = "Email is required";
        valid = false;
      } else {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(this.form.email)) {
          this.errors.email = "Invalid email format";
          valid = false;
        }
      }
      if (!this.form.mobileNumber.trim()) {
        this.errors.mobile = "Mobile Number is required";
        valid = false;
      }

    
      if (!this.form.password.trim()) {
        this.errors.password = "Password is required";
        valid = false;
      }

      return valid;
    },

    handleSubmit() {
      if (!this.validateForm()) return;

      this.$emit("submitForm", { ...this.form });
    },

    resetForm() {
      this.form = {
        id: null,
        fullName: "",
        email: "",
        mobileNumber: "",
        password: "",
        dob: "",
      };
      this.errors = {};
      this.$emit("cancelEdit");
    },
  },
};
</script>

<style scoped>
.card {
  width: 380px;
  background: #fff;
  border: 1px solid #e6e6e6;
  padding: 18px;
  border-radius: 12px;
}

h2 {
  margin-bottom: 16px;
}

.field {
  margin-bottom: 12px;
}

label {
  display: block;
  font-weight: 600;
  margin-bottom: 5px;
}

.req {
  color: red;
}

input {
  width: 100%;
  padding: 9px;
  border-radius: 8px;
  border: 1px solid #cfcfcf;
  outline: none;
}

.error {
  color: red;
  font-size: 13px;
  margin-top: 4px;
}

.btns {
  display: flex;
  gap: 10px;
}

.btn {
  padding: 10px 14px;
  border: none;
  cursor: pointer;
  border-radius: 8px;
}

.primary {
  background: #1976d2;
  color: white;
}

.gray {
  background: gray;
  color: white;
}
</style>
