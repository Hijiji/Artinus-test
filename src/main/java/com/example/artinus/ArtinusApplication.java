package com.example.artinus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //springBoot의 자동설정, Bean읽기와 생성이 자동으로 설정된다. 해당 어노테이션이 존재하는 위치부터 설정을 읽기 때문에 프로젝트 최상단에 위치해야한다.
public class ArtinusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtinusApplication.class, args);//run메서드는 내부톰캣을 실행시킨다.
	}

}
