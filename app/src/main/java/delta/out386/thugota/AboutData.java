package delta.out386.thugota;

import java.io.File;
import java.io.Serializable;

public class AboutData {
    String name, link;
    public AboutData(String name,  String license, String link) {
        this.name = name + ", licenced under " + license;
        this.link = link;
    }
}
