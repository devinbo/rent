package com.xxz.rent.search;

import com.xxz.rent.search.dao.EsProductDao;
import com.xxz.rent.search.domain.EsProduct;
import com.xxz.rent.search.repository.EsProductRepository;
import org.elasticsearch.action.search.SearchResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallSearchApplicationTests {
    @Autowired
    private EsProductDao productDao;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Test
    public void contextLoads() {
    }
    @Test
    public void testGetAllEsProductList(){
        List<EsProduct> esProductList = productDao.getAllEsProductList(null);
        System.out.print(esProductList);
    }
    @Test
    public void testEsProductMapping(){
        elasticsearchTemplate.putMapping(EsProduct.class);
        Map mapping = elasticsearchTemplate.getMapping(EsProduct.class);
        System.out.println(mapping);
    }

    //添加拼音分词mapping
    @Test
    public void testAddPcm() {
//        elasticsearchTemplate.putMapping();
    }
}
