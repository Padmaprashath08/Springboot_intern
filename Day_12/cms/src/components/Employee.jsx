import { useEffect, useState } from "react";
import axios from "axios";

const Employee = () => {
  const [employees, setEmployees] = useState([]);

  const fetchEmployees = async () => {
    try {
      const token = localStorage.getItem("token"); // ✅ get the token
      const res = await axios.get("http://localhost:8080/employee", {
        headers: {
          Authorization: `Bearer ${token}`, // ✅ attach token in header
        },
      });
      console.log(res.data);
      setEmployees(res.data);
    } catch (err) {
      console.error("Error fetching employees", err);
      alert("Access Denied. You are not authorized.");
    }
  };

  useEffect(() => {
    fetchEmployees();
  }, []);

  const containerStyle = {
    width: "90%",
    margin: "40px auto",
    textAlign: "center",
  };

  const tableStyle = {
    width: "100%",
    borderCollapse: "collapse",
  };

  const thStyle = {
    backgroundColor: "#0066cc",
    color: "white",
    padding: "10px",
    border: "1px solid #ddd",
  };

  const tdStyle = {
    padding: "10px",
    border: "1px solid #ddd",
  };

  const rowStyleEven = {
    backgroundColor: "#f2f2f2",
  };

  return (
    <section style={containerStyle}>
      <h2>Employee List</h2>
      {employees.length === 0 ? (
        <p>No employees found.</p>
      ) : (
        <table style={tableStyle}>
          <thead>
            <tr>
              <th style={thStyle}>ID</th>
              <th style={thStyle}>Name</th>
              <th style={thStyle}>UserName</th>
              <th style={thStyle}>Email</th>
              <th style={thStyle}>RoleName</th>
            </tr>
          </thead>
          <tbody>
            {employees.map((emp, index) => (
              <tr
                key={emp.id}
                style={index % 2 === 0 ? rowStyleEven : {}}
                onMouseOver={(e) => (e.currentTarget.style.backgroundColor = "#e0f0ff")}
                onMouseOut={(e) =>
                  (e.currentTarget.style.backgroundColor = index % 2 === 0 ? "#f2f2f2" : "")
                }
              >
                <td style={tdStyle}>{emp.empId}</td>
                <td style={tdStyle}>{emp.name}</td>
                <td style={tdStyle}>{emp.userName}</td>
                <td style={tdStyle}>{emp.email}</td>
                <td style={tdStyle}>
                     {emp.roles.map(role => role.roleName).join(", ")}
                </td>

              </tr>
            ))}
          </tbody>
        </table>
      )}
    </section>
  );
};

export default Employee;
