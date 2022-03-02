package TemaOOP;

import org.apache.commons.lang3.ArrayUtils;

//Create a small application that mimics a library catalog.
// It needs to be able to add books, delete books and list books.
// Books are of two kinds: novels and art albums. They both have names and number of pages.
// Novels have type (like mystery, sf, etc.) while albums have paper quality.
// Model these entities (book, novel, album) with different classes and inheritance.
//        Example:
//        - use method add in order to add in the library several books (novels and art)
//        - use method delete to delete one book of type novel and one of type art
//        - list the name of all the books from library

public class Main {
    public static void main(String[] args) {

        Novel novel = new Novel();
        novel.setName("Ulysses");
        novel.setType("SF");
        novel.setNrpages(240);

        Novel novel1 = new Novel();
        novel1.setName("The Great Gatsby");
        novel1.setType("Mystery");
        novel1.setNrpages(470);

        Novel novel2 = new Novel();
        novel2.setName("Invisible Man");
        novel2.setType("SF");
        novel2.setNrpages(350);

        Novel novel3 = new Novel();
        novel3.setName("Native Son");
        novel3.setType("Family");
        novel3.setNrpages(270);

        Novel novel4 = new Novel();
        novel4.setName("A Passage To India");
        novel4.setType("History");
        novel4.setNrpages(477);

        Album album = new Album();
        album.setName("The Art");
        album.setNrpages(78);
        album.setPaper("Good Quality");

        Album album1 = new Album();
        album1.setName("Album Cover");
        album1.setNrpages(120);
        album1.setPaper("Very Good Quality");

        Album album2 = new Album();
        album2.setName("The Art Book");
        album2.setNrpages(240);
        album2.setPaper("Very Good Quality");

        Album album3 = new Album();
        album3.setName("The Story of Art");
        album3.setNrpages(654);
        album3.setPaper("Medium Quality");

        Album album4 = new Album();
        album4.setName("The Pound Era");
        album4.setNrpages(325);
        album4.setPaper("Good Quality");

        Book[] bookList = new Book[]{novel, novel1, album, album1};

        bookList = ArrayUtils.add(bookList, novel2);
        System.out.println("Cartea: " + novel2.getName() + " a fost adaugata");
        bookList = ArrayUtils.add(bookList, novel3);
        System.out.println("Cartea: " + novel3.getName() + " a fost adaugata");
        bookList = ArrayUtils.add(bookList, novel4);
        System.out.println("Cartea: " + novel4.getName() + " a fost adaugata");
        bookList = ArrayUtils.add(bookList, album2);
        System.out.println("Cartea: " + album2.getName() + " a fost adaugata");
        bookList = ArrayUtils.add(bookList, album3);
        System.out.println("Cartea: " + album3.getName() + " a fost adaugata");
        bookList = ArrayUtils.add(bookList, album4);
        System.out.println("Cartea: " + album4.getName() + " a fost adaugata");
        bookList = ArrayUtils.remove(bookList, 6);
        System.out.println("Cartea: " + novel4.getName() + " a fost scoasa");
        bookList = ArrayUtils.remove(bookList, 8);
        System.out.println("Cartea: " + album4.getName() + " a fost scoasa");

        Library library = new Library();
        library.setName("My Library");
        library.setAdress("Stoke-on-Trent, UK");
        library.setBooks(bookList);
        listNamesBooks(library.getBooks());
    }

    private static void listNamesBooks(Book[] books) {
        Book[] x = books;
        int var4 = x.length;
        System.out.println("Biblioteca are urmatoarele carti: ");
        for (int i = 0; i < var4; i++) {
            Book book = x[i];
            System.out.println(book.getName());
        }
    }
}
