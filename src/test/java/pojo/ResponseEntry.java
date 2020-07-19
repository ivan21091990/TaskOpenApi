package pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ResponseEntry {
    @NotNull()
    private int page;
    @NotNull
    private int perPage;
    @NotNull
    private int total;
    @NotNull
    private int totalPages;
    @NotNull
    @Size(min = 1)
    @Valid
    private DataEntry[] data;
    @NotNull
    @Valid
    private AdEntry ad;

    @JsonCreator
    public ResponseEntry(
            @JsonProperty("page") int page,
            @JsonProperty("per_page") int perPage,
            @JsonProperty("total") int total,
            @JsonProperty("total_pages") int totalPages,
            @JsonProperty("data") DataEntry[] data,
            @JsonProperty("ad") AdEntry ad) {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
        this.ad = ad;
    }

    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public DataEntry[] getData() {
        return data;
    }

    public AdEntry getAd() {
        return ad;
    }
}
