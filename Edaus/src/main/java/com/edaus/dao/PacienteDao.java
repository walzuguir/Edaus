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
			PreparedStatement ps = con.prepareStatement("INSERT INTO paciente (id, nome, email, celular, senha, sexo, cpf) VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, u.getid());
			ps.setString(2, u.getnome());
			ps.setString(3, u.getemail());
			ps.setString(4, u.getcelular());
			ps.setString(5, u.getsenha());
			ps.setString(6, u.getsexo());
			ps.setString(7, u.getcpf());
			status = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	
	
	public static Paciente getRegistroById(int id) {
		Paciente paciente = null;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM paciente WHRE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				paciente = new Paciente();
				paciente.setid(rs.getInt("id"));
				paciente.setcelular(rs.getString("celular"));
				paciente.setemail(rs.getString("email"));
				paciente.setnome(rs.getString("nome"));
				paciente.setsenha(rs.getString("senha"));
				paciente.setsexo(rs.getString("sexo"));
				paciente.setcpf(rs.getString("cpf"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return paciente;
	}
	
	public static int updatePaciente(Paciente u) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE paciente SET nome=?, " + "email=?, celular=?, senha=?, sexo=?, cpf=? WHERE id=?");
			
			ps.setString(1, u.getnome());
			ps.setString(2, u.getemail());
			ps.setString(3, u.getcelular());
			ps.setString(4, u.getsenha());
			ps.setString(5, u.getsexo());
			ps.setString(6, u.getcpf());
			ps.setInt(7, u.getid());
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
			PreparedStatement ps = con.prepareStatement("SELECT * FROM paciente WHERE id");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setid(rs.getInt("id"));
				paciente.setnome(rs.getString("nome"));
				paciente.setemail(rs.getString("email"));
				paciente.setsenha(rs.getString("senha"));
				paciente.setsenha(rs.getString("sexo"));
				paciente.setcpf(rs.getString("cpf"));
				list.add(paciente);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}	 