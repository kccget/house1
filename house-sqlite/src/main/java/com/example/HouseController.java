package com.example;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HouseController {

    private final HouseRepository repo;

    public HouseController(HouseRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> params) {
        Map<String, Object> res = new HashMap<>();
        if ("admin".equals(params.get("username")) && "123456".equals(params.get("password"))) {
            res.put("code", 200);
            res.put("msg", "登录成功");
        } else {
            res.put("code", 500);
            res.put("msg", "账号或密码错误");
        }
        return res;
    }

    @GetMapping("/house")
    public Page<House> list(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "id"));
        if (keyword.isBlank()) {
            return repo.findAll(pageable);
        }
        return null;
    }

    @PostMapping("/house")
    public House add(@RequestBody House house) {
        return repo.save(house);
    }

    @PutMapping("/house/{id}")
    public House update(@PathVariable Long id, @RequestBody House house) {
        house.setId(id);
        return repo.save(house);
    }

    @DeleteMapping("/house/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
