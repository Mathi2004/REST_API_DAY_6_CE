package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Model.Child;
import com.example.demo.Service.ChildService;

@RestController
public class ChildController {
     @Autowired
     ChildService cs;
     @PostMapping("addchild")
     public Child add(@RequestBody Child c)
     {
    	 return cs.saveinfo(c);
     }
     @PostMapping("addndetails")
     public List<Child> adddetails(@RequestBody List<Child> c)
     {
    	 return cs.savedetails(c);
     }
     @GetMapping("show")
     public List<Child> display()
     {
    	 return cs.showinfo();
     }
     @GetMapping("showbyid/{id}")
     public Optional<Child> displaybyid(@PathVariable int id)
     {
    	 return cs.showdetails(id);
     }
     @GetMapping("sort/{str}")
     public List<Child> getsortinfo(@PathVariable String str)
     {
    	 return cs.sortinfo(str);
     }
     @GetMapping("paging/{pgno}/{pgsize}")
     public List<Child> showpageinfo(@PathVariable int pgno,@PathVariable int pgsize)
     {
     return cs.getbyPage(pgno, pgsize);
     }
     @GetMapping("sortpaging/{pgno}/{pgsize}/{str}")
     public List<Child> sortpageinfo(@PathVariable int pgno,@PathVariable int pgsize,@PathVariable String str)
     {
    	 return cs.sortpaging(pgno, pgsize, str);
     }
     @PostMapping("update")
     public Child modify(@RequestBody Child c)
     {
    	 return cs.update(c);
     }
     @PostMapping("updatebyid/{id}")
     public String modifybyid(@PathVariable int id,Child c)
     {
    	 return cs.updatebyid(id, c);
     }
     @DeleteMapping("delete")
     public void remove(@RequestBody Child c)
     {
    	 cs.delete(c);
     }
     @DeleteMapping("deletebyid/{id}")
     public void removebyid(@PathVariable int id)
     {
    	 cs.deletebyid(id);
     }
}
