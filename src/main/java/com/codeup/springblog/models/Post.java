package com.codeup.springblog.models;
import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    public Post(long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

        public long getId() {
            return id;
        }

        public void setId(long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 100)
    private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String body;

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }




    @ManyToOne
//    @JoinColumn(name = "user_id")  <--this is useful for when we are using the <TABLE_NAME>_id naming convention
    private User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
}
