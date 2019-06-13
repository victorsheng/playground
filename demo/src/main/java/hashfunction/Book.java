package hashfunction;

import java.util.Objects;

public class Book {

  private String name;

  private int no;

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Book{");
    sb.append("name='").append(name).append('\'');
    sb.append(", no=").append(no);
    sb.append('}');
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return no == book.no &&
        Objects.equals(name, book.name);
  }


  @Override
  public int hashCode() {
    return Objects.hash(name, no);
  }
}
