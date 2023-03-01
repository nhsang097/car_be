package mockproject.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImagesTest {

    @Mock
    private Images imagesMock;

    @InjectMocks
    private Images images;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetImageId() {
        Long imageId = 1L;
        images.setImageId(imageId);

        Long result = images.getImageId();

        assertEquals(imageId, result);
    }

    @Test
    public void testSetImageId() {
        Long imageId = 1L;
        images.setImageId(imageId);

        Long result = images.getImageId();

        assertEquals(imageId, result);
    }

    @Test
    public void testGetUrl() {
        String url = "https://example.com/image.jpg";
        images.setUrl(url);

        String result = images.getUrl();

        assertEquals(url, result);
    }

    @Test
    public void testSetUrl() {
        String url = "https://example.com/image.jpg";
        images.setUrl(url);

        String result = images.getUrl();

        assertEquals(url, result);
    }

    @Test
    public void testEquals() {
        Long imageId = 1L;
        String url = "https://example.com/image.jpg";

        Images images1 = new Images();
        images1.setImageId(imageId);
        images1.setUrl(url);

        Images images2 = new Images();
        images2.setImageId(imageId);
        images2.setUrl(url);

        assertEquals(images1, images2);
    }

    @Test
    public void testNotEquals() {
        Long imageId1 = 1L;
        String url1 = "https://example.com/image1.jpg";

        Long imageId2 = 2L;
        String url2 = "https://example.com/image2.jpg";

        Images images1 = new Images();
        images1.setImageId(imageId1);
        images1.setUrl(url1);

        Images images2 = new Images();
        images2.setImageId(imageId2);
        images2.setUrl(url2);

        assertEquals(false, images1.equals(images2));
    }

    @Test
    public void testToString() {
        Long imageId = 1L;
        String url = "https://example.com/image.jpg";

        Images images = new Images();
        images.setImageId(imageId);
        images.setUrl(url);

        String expected = "Images(imageId=1, url=https://example.com/image.jpg)";
        String result = images.toString();

        assertEquals(expected, result);
    }

    @Test
    public void testConstructor() {
        Long imageId = 1L;
        String url = "https://example.com/image.jpg";

        Images images = new Images(imageId, url);

        assertEquals(imageId, images.getImageId());
        assertEquals(url, images.getUrl());
    }

    @Test
    public void testConstructorWithoutParams() {
        Images images = new Images();

        assertEquals(null, images.getImageId());
        assertEquals(null, images.getUrl());
    }

    @Test
    public void testHashCode() {
        Long imageId = 1L;
        String url = "https://example.com/image";
        Images image1 = new Images(imageId, url);
        Images image2 = new Images(imageId, url);

        assertEquals(image1.hashCode(), image2.hashCode());
    }

    @Test
    public void testBuilder() {
        Long imageId = 1L;
        String url = "https://example.com/image.jpg";

        Images images = Images.builder().imageId(imageId).url(url).build();

        assertEquals(imageId, images.getImageId());
        assertEquals(url, images.getUrl());
    }
}
