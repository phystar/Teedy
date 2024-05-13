package com.sismics.docs.core.dao.jpa;

import com.sismics.docs.BaseTransactionalTest;
import com.sismics.docs.core.dao.TagDao;
import com.sismics.docs.core.model.jpa.Tag;
import org.junit.Assert;
import org.junit.Test;

public class TagDaoTest extends BaseTransactionalTest {

    @Test
    public void testTagDao() throws Exception {
        // Create a new tag
        Tag tag = new Tag();
        tag.setName("Test Tag");

        // Save the tag
        TagDao tagDao = new TagDao();

        String id = tagDao.create(tag, "test");

        // Retrieve the tag
        Tag retrievedTag = tagDao.getById(id);

        // Check the result
        Assert.assertNotNull(retrievedTag);
        Assert.assertEquals("Test Tag", retrievedTag.getName());
    }
}