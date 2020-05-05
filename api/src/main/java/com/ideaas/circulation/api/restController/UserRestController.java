package com.ideaas.circulation.api.restController;

import com.ideaas.services.domain.User;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserRestController {

    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{username}")
    public User get(@PathVariable String username) {
        return usuarioService.get(username);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list/{pageSize}/{pageNo}/{sortBy}")
    public List<User> findAll(@PathVariable Integer pageSize, @PathVariable Integer pageNo, @PathVariable String sortBy) {
        return usuarioService.findAll(pageSize, pageNo, sortBy);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list/{pageSize}/{pageNo}")
    public List<User> findAll(@PathVariable Integer pageSize, @PathVariable Integer pageNo) {
        return usuarioService.findAll(pageSize, pageNo, "id");
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list/{pageSize}")
    public List<User> findAll(@PathVariable Integer pageSize) {
        return usuarioService.findAll(pageSize, 0, "id");
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User userNew) {
        userNew.setPassword(bCryptPasswordEncoder.encode(userNew.getPassword()));
        User user = usuarioService.save(userNew);

        return new ResponseEntity(user, HttpStatus.CREATED);
    }


    @GetMapping("me")
    public ResponseEntity<User> me() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = usuarioService.get(currentPrincipalName);

        return new ResponseEntity(user, HttpStatus.OK);
    }
}
