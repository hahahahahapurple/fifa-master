package com.noah.fifa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {
    @Autowired
    private MatchService mservice;

    @Autowired
    private MatchRepo mrepo;

    @GetMapping("/all")
    public String getAllMatches() {
        return "";
    }

    @GetMapping("/group/{gname}")
    public String getWinnerByGroup(@PathVariable String gname) {
        return "";
    }

    @GetMapping("/group-winners")
    public String getGroupWinners() {
        return "";
    }

    @GetMapping("/overall-winner")
    public String getOverallWinner() {
        return "";
    }

    @GetMapping("/display")
    public List<Matches> getAll() {
        return mrepo.findAll();
    }
}
