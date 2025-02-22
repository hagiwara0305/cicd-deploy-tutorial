package com.example.project.demo_project;

import com.github.springtestdbunit.dataset.AbstractDataSetLoader;
import java.io.InputStream;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.springframework.core.io.Resource;

public class XmlDataLoader extends AbstractDataSetLoader {
    @Override
    protected IDataSet createDataSet(Resource resource) throws Exception {
      FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
      builder.setColumnSensing(true);
      try (InputStream stream = resource.getInputStream()) {
        return builder.build(stream);
      }
    }
  }
  