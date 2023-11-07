package homework.archive.tests;

import homework.archive.dao.Archive;
import homework.archive.dao.ArchiveImpl;
import homework.archive.model.Documents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArchiveImplTest {
    Archive archive;
    LocalDateTime now = LocalDateTime.now();

    Documents[] documents;

    @BeforeEach
    void setUp() {
        archive = new ArchiveImpl(7);
        documents = new Documents[6];
        documents[0] = new Documents(1, 1, "t1", "url1", now.minusDays(7));
        documents[1] = new Documents(1, 2, "t2", "url1", now.minusDays(7));
        documents[2] = new Documents(1, 3, "t3", "url1", now.minusDays(5));
        documents[3] = new Documents(2, 1, "t1", "url1", now.minusDays(7));
        documents[4] = new Documents(2, 2, "t2", "url1", now.minusDays(7));
        documents[5] = new Documents(2, 3, "t3", "url1", now.minusDays(8));

        for (int i = 0; i < documents.length; i++) {
            archive.addDocument(documents[i]);
        }
    }

    @Test
    void addDocument() {
        assertFalse(archive.addDocument(null));
        assertFalse(archive.addDocument(documents[1]));
        Documents documents1 = new Documents(1, 4, "t", "url", now);
        assertTrue(archive.addDocument(documents1));
        assertEquals(7, archive.size());
        assertFalse(archive.addDocument(documents1));
        archive.printArray();

    }

    @Test
    void removeDocument() {
        assertTrue(archive.removeDocument(1, 1));
        assertEquals(5, archive.size());
        assertNull(archive.getDocumentFromArchive(1, 1));
    }

    @Test
    void updateDocument() {
        assertTrue(archive.updateDocument(1, 1, "newUrl"));
        assertEquals("newUrl", archive.getDocumentFromArchive(1, 1).getUrl());
    }

    @Test
    void getDocumentFromArchive() {
        assertEquals(documents[3], archive.getDocumentFromArchive(1, 2));
        assertNull(archive.getDocumentFromArchive(4, 2));
    }

    @Test
    void getAllDocumentFromArchive() {
        Arrays.sort(documents);
        Documents[] doc = {documents[5], documents[3], documents[4]};
        assertArrayEquals(doc, archive.getAllDocumentFromArchive(2));
        for (int i = 0; i < doc.length; i++) {
            System.out.println(doc[i]);
        }
    }

    @Test
    void getAllDocumentBetweenDate() {
        Arrays.sort(documents);
        Documents[] doc = {documents[3], documents[0], documents[4], documents[1]};
        assertArrayEquals(doc, archive.getAllDocumentBetweenDate(now.minusDays(8), now.minusDays(6)));
        for (int i = 0; i < doc.length; i++) {
            System.out.println(doc[i]);
        }
    }

    @Test
    void size() {
        assertEquals(6, archive.size());
    }
}