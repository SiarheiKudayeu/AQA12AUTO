package utils.driver.constants;

public enum URL {
    GUINNESS("https://www.guinnessworldrecords.com/records/"),
    GUINNESS_LOGIN("https://www.guinnessworldrecords.com/account/login"),
    AUTO_PRACTICE("http://www.automationpractice.pl/index.php"),
    GUINNESS_SEARCH("https://www.guinnessworldrecords.com/search?term=%2A"),
    AUTO_PRACTICE_BOX("http://www.automationpractice.pl/index.php?id_category=3&controller=category");
    private String url;

    public String getUrl() {
        return url;
    }

    URL(String url) {
        this.url = url;
    }
}
