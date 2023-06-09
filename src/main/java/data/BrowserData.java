package data;

public enum BrowserData {
  CHROME("chrome"),
  OPERA("opera"),
  FIREFOX("firefox");

  private String name;

  BrowserData(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
