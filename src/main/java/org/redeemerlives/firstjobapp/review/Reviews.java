package org.redeemerlives.firstjobapp.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.redeemerlives.firstjobapp.company.Company;

@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String reviewBody;
    private String title;
    private double rating;

    @JsonIgnore
    @ManyToOne
    private Company company;

    public Reviews() {

    }

    public Reviews(int id, String reviewBody, String title, double rating, Company company) {
        this.id = id;
        this.reviewBody = reviewBody;
        this.title = title;
        this.rating = rating;
        this.company = company;
    }

    public Reviews(String reviewBody, Company company) {
        this.reviewBody = reviewBody;
        this.company = company;
    }

    public Reviews(String reviewBody, Company company, String title, double rating) {
        this.reviewBody = reviewBody;
        this.company = company;
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }


}
