package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

//このクラスが Spring Framework のコンポーネント(部品）であることを示す
@Component
//このクラスのインスタンスがセッションスコープで管理されることを示す
//ユーザーのセッションごとに 1 つのインスタンスが生成され、セッションが終了するまで保持
//※セッションとは（ユーザーのログインからログアウトまでの一連の動き）
@SessionScope
public class Account {

	private String name;

	public Account() {
	}

	//Accountオブジェクト初期化時にアカウント名を設定
	//オブジェクトの初期化時にアカウント名を一度だけ設定するために使用
	public Account(String name) {
		this.name = name;
	}

	//アカウント名の取得
	//オブジェクトのアカウント名をいつでも読み取るために使用
	public String getName() {
		return name;
	}

	//アカウント名の設定
	//オブジェクトのアカウント名をいつでも変更するために使用
	public void setName(String name) {
		this.name = name;
	}
}

//モデルの役割
//エンティティクラスから取得したデータを処理したり、
//エンティティクラスにデータを保存したりする
//モデルはビジネスロジック
//(アプリケーションが特定のビジネス上の要求やルールに従ってデータを処理し、操作する部分)