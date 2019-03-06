package com.member.member;

import com.member.member.Service.MembeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MemberServiceImplTest {
    private MembeServiceImpl members;

    @Before
    public void setUp() throws Exception {
        members = new MembeServiceImpl();
    }

    @Test
    public void testCreate(){
        Member product = new Member("123","asdf","contoh","12313","adfddfa");
        members.create(product);

        Assert.assertTrue("Total harus ada 1", members.findAll().size()==1);

        Member temp = members.findById("123");
        Assert.assertTrue("Product harus ada", product.getId().equals(temp.getId()));
    }

    @Test
    public void testFindId(){

        Member product = members.findById("kosong");
        Assert.assertTrue("Product harus null", product == null);

        members.create(new Member("234","ababab","cth","500","dfafdsf"));
        Assert.assertTrue("ID harus ketemu", members.findById("234").getEmail().equals("ababab"));
    }

    @Test
    public void testFindAll(){
        members.create(new Member("234","ababab","ctg","500","Adsfdaf"));
        Member product = new Member("123","asdf","ctg","200","ADSfadsf");
        members.create(product);

        Assert.assertTrue("Size harus 2", members.findAll().size()==2);
    }

    @Test
    public void testUpdate(){
        members.create(new Member("234","ababab","ctg","500","ADfdasf"));
        members.update(new Member("234","hahaahh","hai","800","ADSfadsf"));

        Assert.assertTrue("Nama harus terupdate", members.findById("234").getEmail().compareTo("hahaahh")==0);

        Member member = members.update(new Member("534","ababab","ctg","500","ADfac"));

        Assert.assertTrue(member==null);
    }

    @Test
    public void testDelete(){
        Member product = members.delete("534");

        Assert.assertTrue(product==null);

        members.create(new Member("234","ababab","ctg","500","hai"));
        members.create(new Member("534","hahaahh","hai","800","hai"));

        Assert.assertTrue("Size harus 2", members.findAll().size()==2);

        members.delete("234");
        Assert.assertTrue("Harus di delete", members.findById("234")==null);

        members.delete("534");
        Assert.assertTrue("Size harus 0", members.findAll().size()==0);
    }
}
