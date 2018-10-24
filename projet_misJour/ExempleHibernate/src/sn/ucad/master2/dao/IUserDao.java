package sn.ucad.master2.dao;

import java.util.List;

import sn.ucad.master2.bo.User;

public interface IUserDao {
	public void addUser(User user);
	public void deleteUser(int userid);
	public void updateUser(User user);
	public List<User> getAllUsers();
	public User getUserById(int userid);
}
