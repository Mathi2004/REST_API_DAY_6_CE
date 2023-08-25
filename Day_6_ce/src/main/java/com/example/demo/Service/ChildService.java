package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Child;
import com.example.demo.Repository.ChildRepo;

@Service
public class ChildService {
    @Autowired
    ChildRepo cr;
    public Child saveinfo(Child c)
    {
    	return cr.save(c);
    }
    public List<Child> savedetails(List<Child> c)
    {
    	return cr.saveAll(c);
    }
    public List<Child> showinfo()
    {
    	return cr.findAll();
    }
    public Optional<Child> showdetails(int id)
    {
    	return cr.findById(id);
    }
    public List<Child> sortinfo(String s)
    {
    	return cr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
    }
    public List<Child> getbyPage(int pgno,int pgsize)
    {
     Page<Child> p=cr.findAll(PageRequest.of(pgno,pgsize));
    return p.getContent();
    }
    public List<Child> sortpaging(int pgno,int pgsize,String str)
    {
    Page<Child> p=cr.findAll(PageRequest.of(pgno, pgsize,Sort.by(str)));
    	return p.getContent();
    }
    public Child update(Child c)
    {
    	return cr.saveAndFlush(c);
    }
    public String updatebyid(int id,Child c)
    {
    	cr.saveAndFlush(c);
    	if(cr.existsById(id))
    	{
    		return "updated";
    	}
    	else
    	{
    		return "Invalud Id";
    	}
    }
    public void delete(Child c)
    {
    	cr.delete(c);
    }
    public void deletebyid(int id)
    {
    	cr.deleteById(id);
    }
}
