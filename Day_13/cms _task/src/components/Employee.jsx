import React, { useEffect, useState } from "react";
import axios from "axios";

const Employee = () => {
  const [employees, setEmployees] = useState([]);
  const [editingId, setEditingId] = useState(null);
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    userName: "",
    password: "",
    roles: [],
  });

  const role = localStorage.getItem("role");
  const token = localStorage.getItem("token");

  useEffect(() => {
    fetchEmployees();
  }, []);

  const fetchEmployees = async () => {
    try {
      const res = await axios.get("http://localhost:8080/employee", {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      setEmployees(res.data);
    } catch (err) {
      console.error("Error fetching employees:", err);
      alert("Failed to load employee data.");
    }
  };

  const handleDelete = async (id) => {
    if (!window.confirm("Are you sure you want to delete this employee?")) return;
    try {
      await axios.delete(`http://localhost:8080/employee/${id}`, {
        headers: { Authorization: `Bearer ${token}` },
      });
      alert("Employee deleted successfully");
      setEmployees((prev) => prev.filter((emp) => emp.empId !== id));
    } catch (err) {
      console.error("Error deleting employee:", err);
      alert("Failed to delete employee.");
    }
  };

  const startEdit = (emp) => {
    setEditingId(emp.empId);
    setFormData({
      name: emp.name,
      email: emp.email,
      userName: emp.userName,
      password: emp.password,
      roles: emp.roles.map(r => r.roleName), // just role names for editing
    });
  };

  const handleChange = (e) => {
    setFormData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value,
    }));
  };

  const handleRoleChange = (e) => {
    const roles = e.target.value.split(",").map(role => role.trim());
    setFormData((prev) => ({
      ...prev,
      roles,
    }));
  };

  const submitUpdate = async (id) => {
    // convert role names to array of objects
    const roleObjects = formData.roles.map(role => ({ roleName: role }));

    const payload = {
      empId: id,
      name: formData.name,
      email: formData.email,
      userName: formData.userName,
      password: formData.password,
      roles: roleObjects,
    };

    try {
      await axios.put(`http://localhost:8080/employee/${id}`, payload, {
        headers: { Authorization: `Bearer ${token}` },
      });
      alert("Employee updated successfully");
      setEditingId(null);
      fetchEmployees();
    } catch (err) {
      console.error("Error updating employee:", err);
      alert("Failed to update employee.");
    }
  };

  const cancelEdit = () => setEditingId(null);

  // Styles
  const tableStyle = { width: "100%", borderCollapse: "collapse", marginTop: "20px" };
  const thStyle = { border: "1px solid #ccc", padding: "10px", background: "#f2f2f2", textAlign: "left" };
  const tdStyle = { border: "1px solid #ccc", padding: "10px" };
  const inputStyle = { padding: "6px", width: "100%" };
  const buttonStyle = {
    padding: "6px 12px",
    marginRight: "8px",
    border: "none",
    borderRadius: "4px",
    cursor: "pointer",
  };
  const updateButtonStyle = { ...buttonStyle, backgroundColor: "#ffc107", color: "#000" };
  const deleteButtonStyle = { ...buttonStyle, backgroundColor: "#dc3545", color: "#fff" };
  const saveButtonStyle = { ...buttonStyle, backgroundColor: "#28a745", color: "#fff" };
  const cancelButtonStyle = { ...buttonStyle, backgroundColor: "#6c757d", color: "#fff" };

  return (
    <div style={{ padding: "30px", fontFamily: "Arial, sans-serif" }}>
      <h2>Employee Details</h2>
      <table style={tableStyle}>
        <thead>
          <tr>
            <th style={thStyle}>ID</th>
            <th style={thStyle}>Name</th>
            <th style={thStyle}>Email</th>
            <th style={thStyle}>Username</th>
            <th style={thStyle}>Roles</th>
            {role === "ROLE_ADMIN" && <th style={thStyle}>Actions</th>}
          </tr>
        </thead>
        <tbody>
          {employees.map((emp) => (
            <tr key={emp.empId}>
              <td style={tdStyle}>{emp.empId}</td>
              <td style={tdStyle}>
                {editingId === emp.empId ? (
                  <input name="name" value={formData.name} onChange={handleChange} style={inputStyle} />
                ) : (
                  emp.name
                )}
              </td>
              <td style={tdStyle}>
                {editingId === emp.empId ? (
                  <input name="email" value={formData.email} onChange={handleChange} style={inputStyle} />
                ) : (
                  emp.email
                )}
              </td>
              <td style={tdStyle}>
                {editingId === emp.empId ? (
                  <input name="userName" value={formData.userName} onChange={handleChange} style={inputStyle} />
                ) : (
                  emp.userName
                )}
              </td>
              <td style={tdStyle}>
                {editingId === emp.empId ? (
                  <input
                    name="roles"
                    value={formData.roles.join(", ")}
                    onChange={handleRoleChange}
                    style={inputStyle}
                  />
                ) : (
                  emp.roles?.map(r => r.roleName).join(", ")
                )}
              </td>
              {role === "ROLE_ADMIN" && (
                <td style={tdStyle}>
                  {editingId === emp.empId ? (
                    <>
                      <button style={saveButtonStyle} onClick={() => submitUpdate(emp.empId)}>Save</button>
                      <button style={cancelButtonStyle} onClick={cancelEdit}>Cancel</button>
                    </>
                  ) : (
                    <>
                      <button style={updateButtonStyle} onClick={() => startEdit(emp)}>Update</button>
                      <button style={deleteButtonStyle} onClick={() => handleDelete(emp.empId)}>Delete</button>
                    </>
                  )}
                </td>
              )}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Employee;
