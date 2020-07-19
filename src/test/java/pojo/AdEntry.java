package pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;

public class AdEntry {
    @NotEmpty
    private String company;
    @NotEmpty
    private String url;
    @NotEmpty
    private String text;

    @JsonCreator
    public AdEntry(
            @JsonProperty("company") String company,
            @JsonProperty("url") String url,
            @JsonProperty("text") String text) {
        this.company = company;
        this.url = url;
        this.text = text;
    }

    public String getCompany() {
        return company;
    }

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }
}
