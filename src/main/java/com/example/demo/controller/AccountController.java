package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

@Controller
public class AccountController {

	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	//ログイン画面を表示
	@GetMapping({ "/", "/login", "/logout" })
	public String index(
			@RequestParam(name = "error", defaultValue = "") String error,
			Model model) {
		//セッション情報をすべてクリアする
		session.invalidate();
		//エラーパラメータのチェック
		if (error.equals("notLoggedIn")) {
			model.addAttribute("message", "ログインしてください");
		}
		return "login";
	}

	//ログインを実行
	@PostMapping("/login")
	public String login(
			@RequestParam("name") String name,
			Model model) {
		//名前が空の場合はエラー
		if (name == null || name.length() == 0) {
			model.addAttribute("message", "名前を入力してください");
			return "login";
		}

		//セッション管理されたアカウント情報に名前をセット
		account.setName(name);

		//「/items」へリダイレクト
		return "redirect:/items";
	}
}

//ユーザーからのリクエストを受け取り、適切な処理を行い、結果をユーザーに返すこと
