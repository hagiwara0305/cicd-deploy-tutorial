package com.example.project.demo_project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.demo_project.service.UserListService;
import com.example.project.demo_project.service.model.UserModel;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@SpringBootTest
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionDbUnitTestExecutionListener.class
})
@Transactional
@DbUnitConfiguration(dataSetLoader = XmlDataLoader.class)
public class DBUnitTests {
    @Autowired
    private UserListService userListService;

    @Test
    @DisplayName("DBUnitを使用したテスト用DBへアクセス")
    @DatabaseSetup("/dataset/user_find_by_id.xml")
    public void testUserTable() throws Exception {
        UserModel expectedUser = UserModel.builder()
            .user_id(1)
            .user_name("サンプルユーザ")
            .build();

        // Act
        String userListString = userListService.selectUser();

        // Assert
        assertNotNull(userListString);
        assertEquals(userListString, "["+expectedUser.getUser_name()+"]");
    }
}
