package io.namoosori.travelclub.web.service.logic;

import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.service.ClubService;
import io.namoosori.travelclub.web.service.sdo.TravelClubCdo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ClubServiceLogicTest {

    @Autowired
    private ClubService clubService;

    private TravelClubCdo jejuClub;
    private TravelClubCdo seoulClub;

    @BeforeEach
    public void startUp() {
        this.jejuClub = new TravelClubCdo("jejuClub","jejuClub intro~~~");
        this.clubService.registerClub(jejuClub);
        this.seoulClub = new TravelClubCdo("seoulClub","seoulClub intro~~~");
        this.clubService.registerClub(seoulClub);
    }

    @Test
    public void registerTest() {

        TravelClub sample = TravelClub.sample();
        System.out.println(sample);

        TravelClubCdo sampleCdo = new TravelClubCdo();
        sampleCdo.setName(sample.getName());
        sampleCdo.setIntro(sample.getIntro());

//        this.clubService.registerClub(sampleCdo);
        this.clubService.registerClub(sampleCdo);
//        assertThat(this.clubService.registerClub(sampleCdo)).isEqualTo(sample.getId());
        assertThat(this.clubService.findAll().size()).isEqualTo(1);
    }

    @Test
    public void find() {
        assertThat(this.clubService.findClubsByName(jejuClub.getName())).isNotNull();
    }

    @AfterEach
    public void cleanUp() {

//        this.clubService.remove();
    }

}