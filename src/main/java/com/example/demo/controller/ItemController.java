package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

//このクラスが Spring Framework のコントローラーであることを示す。
@Controller
public class ItemController {

	//依存性注入（DI）を行うために使用
	//CategoryRepository と ItemRepository のインスタンスを、
	//自動的にコントローラーに注入します。
	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ItemRepository itemRepository;

	//商品一覧表示
	// (/items) というURLへのGETリクエストを、
	//index() メソッドで処理することを指定
	@GetMapping("/items")
	public String index(
			//URLのパラメータ categoryId を取得
			@RequestParam(value = "categoryId", defaultValue = "") Integer categoryId,
			//Model オブジェクトを使用して、ビューにデータを渡す
			Model model) {

		//全カテゴリー一覧を取得
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		//商品一覧情報の取得
		List<Item> itemList = null;
		if (categoryId == null) {
			itemList = itemRepository.findAll();
		} else {
			//itemsテーブルをカテゴリーIDを指定して一覧を取得
			itemList = itemRepository.findByCategoryId(categoryId);
		}
		model.addAttribute("items", itemList);

		return "items";
	}
}
