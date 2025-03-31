package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//このクラスが JPA（Java Persistence API）のエンティティであることを示す
@Entity
//エンティティがマッピングされるデータベースのテーブル名を指定
@Table(name = "categories")
public class Category {
	//エンティティの主キー（一意な識別子）となるフィールドを指定
	@Id
	//主キーの生成方法を指定
	//GenerationType.IDENTITY は、データベースの自動インクリメント機能を使用して主キーを生成する
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //カテゴリーID

	private String name; //カテゴリー名

	//ゲッター
	//エンティティのフィールドの値を取得するために使用
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

//エンティティとは、RPGで考えるデータベースに保存されるデータの設計図みたいなもの
//これらの「モノ」や「キャラクター」がどのような情報を持っているかを定義
//データベースのカテゴリー情報を Java オブジェクトとして表現
//データアクセス層（エンティティ）
