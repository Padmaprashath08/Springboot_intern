import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
  const styles = {
    navbar: {
      display: 'flex',
      justifyContent: 'space-between',
      alignItems: 'center',
      backgroundColor: '#2c3e50',
      padding: '1rem 2rem',
      color: 'white',
    },
    logo: {
      fontSize: '1.5rem',
      fontWeight: 'bold',
      color: 'white',
      textDecoration: 'none',
    },
    navLinks: {
      display: 'flex',
      gap: '1.5rem',
    },
    navLink: {
      color: 'white',
      textDecoration: 'none',
      fontWeight: 'bold',
      transition: 'color 0.3s ease',
    }
  };

  const handleMouseEnter = (e) => (e.target.style.color = '#f39c12');
  const handleMouseLeave = (e) => (e.target.style.color = 'white');

  return (
    <nav style={styles.navbar}>
      <Link to="/" style={styles.logo}>EMS</Link>
      <div style={styles.navLinks}>
        <Link to="/login" style={styles.navLink} onMouseEnter={handleMouseEnter} onMouseLeave={handleMouseLeave}>Login</Link>
        <Link to="/register" style={styles.navLink} onMouseEnter={handleMouseEnter} onMouseLeave={handleMouseLeave}>Register</Link>
      </div>
    </nav>
  );
};

export default Navbar;
