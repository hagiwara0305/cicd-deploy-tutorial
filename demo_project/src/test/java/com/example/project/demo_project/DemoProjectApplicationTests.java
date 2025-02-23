package com.example.project.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class DemoProjectApplicationTests {

    @Test
    public void testRootEndpoint(@Autowired MockMvc mvc) throws Exception {
        // /へのGETリクエストを行い、"Hello demo world!"が返ってくることを確認
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())   // ステータス200
                .andExpect(MockMvcResultMatchers.content().string("Hello demo world!"));    // 返却値チェック
    }

    @Test
    public void testGetEndpoint(@Autowired MockMvc mvc) throws Exception {
        // /getへのGETリクエストを行い、"SAMPLE"が返ってくることを確認
        mvc.perform(MockMvcRequestBuilders.get("/get"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("SAMPLE"));
    }

    @Test
    public void testGetEndpointWithParameter(@Autowired MockMvc mvc) throws Exception {
        // /getへのGETリクエストでパラメータ"parameter=sampel"を渡し、"sampel"が返ってくることを確認
        mvc.perform(MockMvcRequestBuilders.get("/get").param("parameter", "sampel"))    // GETパラメータ
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("sampel"));
    }

    @Test
    public void testUserListEndpoint(@Autowired MockMvc mvc) throws Exception {
        // 別環境のDBへ直接アクセス
        // /userListへのGETリクエストを行い、"sampleユーザ"と"sampleユーザ2"を含むJSON配列が返ってくることを確認
        // 返却値の具体的な形式（JSON構造など）に合わせてアサーションを調整してください
        mvc.perform(MockMvcRequestBuilders.get("/userList"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[sampleユーザ, sampleユーザ2]"));
    }
}
