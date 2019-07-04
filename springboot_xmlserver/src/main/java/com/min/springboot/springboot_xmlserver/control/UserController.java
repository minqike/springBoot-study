package com.min.springboot.springboot_xmlserver.control;

import com.min.springboot.springboot_xmlserver.entity.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class UserController {

    @PostMapping(value = "/user",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public User create(@RequestBody User user) {
        user.setName("min : " + user.getName());
        user.setAge(user.getAge() + 100);
        return user;
    }


    @GetMapping(value = "/env",
            produces = {"application/xml;charset=UTF-8"})
    @ResponseBody
    public WmsWcsXmlEnvelope env() {


        ControlArea controlArea = new ControlArea(new Sender("sender"),new Receiver("receiver"),
                new Date(),new RefId("refid1110000222") );

        DataArea dataArea = new DataArea(99,new Location("MHA01","11","22","33"),
                "abc111",new Location("MHA02","44","55","66"),0);


        TransportOrder transportOrder=new TransportOrder(controlArea,dataArea);
        WmsWcsXmlEnvelope envelope = new WmsWcsXmlEnvelope(transportOrder);
        return envelope;
    }

}
