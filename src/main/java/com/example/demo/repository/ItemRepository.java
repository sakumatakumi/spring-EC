package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

//ItemRepository インターフェースは、JpaRepository インターフェースを継承している
//JpaRepository<Item, Integer> は、Item エンティティを操作し、
//主キーの型が Integer であることを指定
//JpaRepository を継承することで、save(), findById(), findAll(), delete() など
//基本的な CRUD 操作を自動的に利用できる

public interface ItemRepository extends JpaRepository<Item, Integer> {

	//items テーブルから category_id が指定された値と一致する、
	//Item エンティティのリストを取得
	//SELECT * FROM items WHERE category_id = ?
	//? には、categoryId の値が入る
	//JpaRepository を継承してるため、
	//save(), findById(), findAll(), delete() などの
	//基本的な CRUD 操作を自動的に利用できる
	List<Item> findByCategoryId(Integer categoryId);
}
