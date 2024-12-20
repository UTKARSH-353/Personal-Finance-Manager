// Form Validation for Login
document.getElementById('login-form').addEventListener('submit', function(event) {
  event.preventDefault();
  
  let email = document.getElementById('email').value;
  let password = document.getElementById('password').value;
  let emailError = document.getElementById('email-error');
  let passwordError = document.getElementById('password-error');
  
  // Reset errors
  emailError.style.display = 'none';
  passwordError.style.display = 'none';
  
  let valid = true;
  
  // Email Validation
  if (!validateEmail(email)) {
    emailError.style.display = 'block';
    valid = false;
  }
  
  // Password Validation
  if (password.trim() === '') {
    passwordError.style.display = 'block';
    valid = false;
  }
  
  if (valid) {
    alert('Login successful!');
    // You can redirect to a dashboard or user profile here.
  }
});

// Form Validation for Registration
document.getElementById('register-form').addEventListener('submit', function(event) {
  event.preventDefault();
  
  let email = document.getElementById('register-email').value;
  let password = document.getElementById('register-password').value;
  let emailError = document.getElementById('register-email-error');
  let passwordError = document.getElementById('register-password-error');
  
  // Reset errors
  emailError.style.display = 'none';
  passwordError.style.display = 'none';
  
  let valid = true;
  
  // Email Validation
  if (!validateEmail(email)) {
    emailError.style.display = 'block';
    valid = false;
  }
  
  // Password Validation
  if (password.length < 6) {
    passwordError.style.display = 'block';
    valid = false;
  }
  
  if (valid) {
    alert('Registration successful!');
    // You can redirect to login page or dashboard here.
  }
});

// Email Validation Function
function validateEmail(email) {
  const re = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  return re.test(String(email).toLowerCase());
}

// Logout Functionality
document.getElementById('logout-btn').addEventListener('click', function() {
  alert('Logged out successfully!');
  // Redirect to login page or clear user session.
});
