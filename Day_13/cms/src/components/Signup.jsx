import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Signup = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [userName, setUserName] = useState("");
  const [roles, setRoles] = useState([]);
  const navigate = useNavigate();

  const handleRoleChange = (e) => {
    const { value, checked } = e.target;
    if (checked) {
      setRoles([...roles, value]);
    } else {
      setRoles(roles.filter((role) => role !== value));
    }
  };

  async function addNewEmployee(e) {
    e.preventDefault();
    const req = await axios.post("http://localhost:8080/api/auth", {
      name,
      email,
      password,
      userName,
      roles,
    });
    console.log(req.data);
    if (req.data) {
      alert(req.data);
    } else {
      alert("Failed");
    }
  }

  // 🖌️ Inline CSS Styles
  const containerStyle = {
    maxWidth: "450px",
    margin: "50px auto",
    padding: "30px",
    backgroundColor: "#f9f9f9",
    borderRadius: "10px",
    boxShadow: "0 0 12px rgba(0, 0, 0, 0.1)",
    fontFamily: "Arial, sans-serif",
  };

  const headingStyle = {
    textAlign: "center",
    color: "#333",
    marginBottom: "25px",
  };

  const labelStyle = {
    display: "block",
    marginBottom: "6px",
    fontWeight: "bold",
    color: "#555",
  };

  const inputStyle = {
    width: "100%",
    padding: "10px",
    marginBottom: "15px",
    borderRadius: "5px",
    border: "1px solid #ccc",
    fontSize: "14px",
  };

  const checkboxLabelStyle = {
    display: "block",
    marginBottom: "10px",
    fontSize: "14px",
    color: "#444",
  };

  const buttonStyle = {
    width: "100%",
    padding: "12px",
    backgroundColor: "#28a745",
    color: "#fff",
    border: "none",
    borderRadius: "5px",
    fontSize: "16px",
    cursor: "pointer",
    marginTop: "10px",
  };

  const loginLinkStyle = {
    textAlign: "center",
    marginTop: "20px",
    color: "#007bff",
    cursor: "pointer",
    fontSize: "14px",
    textDecoration: "underline",
  };

  return (
    <section style={containerStyle}>
      <h2 style={headingStyle}>Sign Up</h2>
      <form onSubmit={addNewEmployee}>
        <label htmlFor="name" style={labelStyle}>Employee Name:</label>
        <input
          type="text"
          id="name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          style={inputStyle}
        />

        <label htmlFor="email" style={labelStyle}>Employee Email:</label>
        <input
          type="email"
          id="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          style={inputStyle}
        />

        <label htmlFor="password" style={labelStyle}>Employee Password:</label>
        <input
          type="password"
          id="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          style={inputStyle}
        />

        <label htmlFor="userName" style={labelStyle}>Employee Username:</label>
        <input
          type="text"
          id="userName"
          value={userName}
          onChange={(e) => setUserName(e.target.value)}
          style={inputStyle}
        />

        <label style={labelStyle}>Employee Roles:</label>
        <label style={checkboxLabelStyle}>
          <input
            type="checkbox"
            value="ROLE_ADMIN"
            checked={roles.includes("ROLE_ADMIN")}
            onChange={handleRoleChange}
          /> Admin
        </label>
        <label style={checkboxLabelStyle}>
          <input
            type="checkbox"
            value="ROLE_USER"
            checked={roles.includes("ROLE_USER")}
            onChange={handleRoleChange}
          /> User
        </label>

        <button type="submit" style={buttonStyle}>Submit</button>
      </form>

      {/* 🔗 Already registered */}
      <div style={loginLinkStyle} >
        Already registered?Login
      </div>
 
    </section>
  );
};

export default Signup;
