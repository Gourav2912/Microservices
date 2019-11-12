package com.example.sample.coreservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import static org.springframework.http.MediaType.*;



@RestController
@RequestMapping("/users")
public class Controller {


  /*  @Autowired
    UserService userService;*/

    @Autowired
    UserServiceJPA userServiceJPA;



    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

        String userrest = userServiceJPA.createUser(userDetails);
        return new ResponseEntity<String>("UserId is "+userrest, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<UserRest> getUserByEmail(@RequestParam(value = "email",required = true) String mail ) {

        if (userServiceJPA.getUserByEmail(mail)!=null) {
            return new ResponseEntity<UserRest>(userServiceJPA.getUserByEmail(mail), HttpStatus.OK);
        }

        else {
            return new ResponseEntity<UserRest>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping(path = "/{UserId}", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUserByUserId(@PathVariable String UserId) {

        if (userServiceJPA.getUserByUserId(UserId)!=null) {
            return new ResponseEntity<UserRest>(userServiceJPA.getUserByUserId(UserId), HttpStatus.OK);
        }

        else {
            return new ResponseEntity<UserRest>(HttpStatus.NOT_FOUND);

        }

    }


}
