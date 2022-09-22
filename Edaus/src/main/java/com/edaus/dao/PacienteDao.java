package com.edaus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edaus.bean.Paciente;

public class PacienteDao {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edaus","root","");	
		}catch (Exception e) {
			System.out.println();
		}
		return con;
	} 
	
	public static int salvarPaciente(Paciente u) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO paciente (nome, email, celular, senha, sexo, cpf) VALUES (?,?,?,?,?,?)");
			ps.setString(1, u.getnome());
			ps.setString(2, u.getemail());
			ps.setString(3, u.getcelular());
			ps.setString(4, u.getsenha());
			ps.setString(5, u.getsexo());
			ps.setString(6, u.getcpf());
			status = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	
	
	public static Paciente getRegistroById(int id) {
		Paciente paciente = new Paciente();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM paciente WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				paciente.setid(rs.getInt("id"));
				paciente.setcelular(rs.getString("celular"));
				paciente.setemail(rs.getString("email"));
				paciente.setnome(rs.getString("nome"));
				paciente.setsenha(rs.getString("senha"));
				paciente.setsexo(rs.getString("sexo"));
				paciente.setcpf(rs.getString("cpf"));
			}
			return paciente;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static int updatePaciente(Paciente p) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE paciente SET nome=?, email=?,"
					+ " celular=?, senha=?, sexo=?, cpf=? WHERE id=?");
			
			ps.setString(1, p.getnome());
			ps.setString(2, p.getemail());
			ps.setString(3, p.getcelular());
			ps.setString(4, p.getsenha());
			ps.setString(5, p.getsexo());
			ps.setString(6, p.getcpf());
			ps.setInt(7, p.getid());
			status = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
			return status;
	}
	
	public static List<Paciente> getAllPacientes(){
		List<Paciente> list = new ArrayList<Paciente>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM paciente");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setid(rs.getInt("id"));
				paciente.setnome(rs.getString("nome"));
				paciente.setemail(rs.getString("email"));
				paciente.setcelular(rs.getString("celular"));
				paciente.setsenha(rs.getString("senha"));
				paciente.setsexo(rs.getString("sexo"));
				paciente.setcpf(rs.getString("cpf"));
				list.add(paciente);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}	 

