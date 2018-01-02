package com.example.sql.service;

import com.example.sql.model.RunoobTbl;

/**
 * 娑撴艾濮熼幒銉ュ經閿涙氨鐝崷锟�"娴ｈ法鏁ら懓锟�"鐟欐帒瀹崇拋鎹愵吀閹恒儱褰� 娑撳閲滈弬褰掓桨閿涙碍鏌熷▔鏇炵暰娑斿鐭戞惔锔肩礉閸欏倹鏆熼敍宀冪箲閸ョ偟琚崹瀣剁礄return 缁鐎�/瀵倸鐖堕敍锟�
 */
public interface BookService {

	/**
	 * 閺屻儴顕楁稉锟介張顒�娴樻稊锟�
	 * 
	 * @param bookId
	 * @return
	 */
	RunoobTbl getById(long bookId);


}
