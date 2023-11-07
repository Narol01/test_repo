package homework.archive.dao;

import homework.archive.model.Documents;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class ArchiveImpl implements Archive {
    static Comparator<Documents> comparator = (p1, p2) -> {
        int res = p1.getDate().compareTo(p2.getDate());
        return res != 0 ? res : Integer.compare(p1.getDocumentId(), p2.getDocumentId());
    };

    Documents[] document;

    int size;

    public ArchiveImpl(int capacity) {
        document = new Documents[capacity];
    }

    //    @Override
//    public boolean addDocument(Documents documents) {
//        if (documents == null || size == document.length || getDocumentFromArchive(documents.getDocumentId(), documents.getFolderId()) != null) {
//            return false;
//        }
//        document[size] = documents;
//        size++;
//        return true;
//    }
    @Override
    public boolean addDocument(Documents documents) {
        if (documents == null || size == document.length || getDocumentFromArchive(documents.getDocumentId(), documents.getFolderId()) != null) {
            return false;
        }
        int index = Arrays.binarySearch(document, 0, size, documents, comparator);
        index = index >= 0 ? index : -index - 1;
        System.arraycopy(document, index, document, index + 1, size - index);
        document[index] = documents;
        size++;
        return true;
    }

    @Override
    public void printArray() {
        for (int i = 0; i < document.length; i++) {
            if (document[i] != null) {
                System.out.println(document[i]);
            }
        }
    }

    @Override
    public boolean removeDocument(int documentId, int FolderId) {
        for (int i = 0; i < document.length; i++) {
            if (document[i].getDocumentId() == documentId && document[i].getFolderId() == FolderId) {
                document[i] = document[size - 1];
                document[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateDocument(int documentId, int FolderId, String url) {
        for (int i = 0; i < document.length; i++) {
            if (document[i].getDocumentId() == documentId && document[i].getFolderId() == FolderId) {
                document[i].setUrl(url);
                return true;
            }
        }
        return false;
    }

    @Override
    public Documents getDocumentFromArchive(int documentId, int FolderId) {
        for (int i = 0; i < size; i++) {
            if (document[i].getFolderId() == FolderId && document[i].getDocumentId() == documentId) {
                return document[i];
            }
        }
        return null;
    }

//    @Override
//    public Documents[] getAllDocumentFromArchive(int FolderId) {
//        int c = 0;
//        for (int i = 0; i < size; i++) {
//            if (document[i].getFolderId() == FolderId) {
//                c++;
//            }
//        }
//        Documents[] doc = new Documents[c];
//        for (int i = 0, j = 0; j < c; i++) {
//            if (document[i].getFolderId() == FolderId) {
//                doc[j++] = document[i];
//            }
//        }
//        return doc;
//    }

    @Override
    public Documents[] getAllDocumentFromArchive(int FolderId) {
        return findPredicate(p -> FolderId == p.getFolderId());
    }

    private Documents[] findPredicate(Predicate<Documents> predicate) {
        Documents[] res = new Documents[size];
        int j = 0; // счетчик найденых фото в альбоме
        for (int i = 0; i < size; i++) {
            if (predicate.test(document[i])) {
                res[j] = document[i];
                j++;
            }
        }
        return Arrays.copyOf(res, j);
    }

    @Override
    public Documents[] getAllDocumentBetweenDate(LocalDateTime date, LocalDateTime dateTo) {
        int c = 0;
        for (int i = 0; i < size; i++) {
            if (document[i].getDate().isAfter(date) && document[i].getDate().isBefore(dateTo)) {
                c++;
            }
        }
        Documents[] doc = new Documents[c];
        for (int i = 0, j = 0; j < c; i++) {
            if (document[i].getDate().isAfter(date) && document[i].getDate().isBefore(dateTo)) {
                doc[j++] = document[i];
            }
        }
        return doc;
    }

    @Override
    public int size() {
        return size;
    }
}
