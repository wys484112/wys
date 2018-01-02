package com.example.sql.service;

import java.util.List;

import com.example.sql.model.User;

/**
 * 娑撴艾濮熼幒銉ュ經閿涙氨鐝崷锟�?"娴ｈ法鏁ら懓锟�"鐟欐帒�?�崇拋鎹愵吀閹恒儱褰�? 娑撳閲滈弬褰掓桨閿涙碍鏌熷▔鏇炵暰娑斿鐭戞惔锔肩礉閸欏�?�鏆熼敍�?冪箲閸ョ偟琚崹瀣剁礄return 缁鐎�?/瀵倸鐖堕敍锟�
 */
public interface UserService {

	/**
	 * 閺屻儴顕楁稉锟介張顒�娴樻稊锟�
	 * 
	 * @param bookId
	 * @return
	 */
	List<User> login(User user);
	int register(User user);

}
