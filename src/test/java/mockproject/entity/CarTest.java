package mockproject.entity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CarTest {

    @Mock
    private List<Images> imagesMock;

    @InjectMocks
    private Car car;

    @Before
    public void setUp() {
        car.setId(1L);
        car.setName("Test Car");
        car.setStock(10);
        car.setStars(4);
        car.setReviews(2);
        car.setImage("test-image.png");
        car.setFeatured("featured");
        car.setVideoDesc("test-video-desc");
        car.setPrice(50000);
        car.setDescription("Test description");
        car.setCategory("Test category");
        car.setCompany("Test company");
    }

    @Test
    public void testSetIsDeleted() {
        car.setIsDeleted(true);
        assertEquals(true, car.isDeleted());
    }

    @Test
    public void testGetImages() {
        List<Images> images = new ArrayList<>();

        Images image1 = new Images();
        image1.setImageId(1L);
        image1.setUrl("test-image-1.png");

        Images image2 = new Images();
        image2.setImageId(2L);
        image2.setUrl("test-image-2.png");

        images.add(image1);
        images.add(image2);

        when(imagesMock.size()).thenReturn(2);
        when(imagesMock.get(0)).thenReturn(image1);
        when(imagesMock.get(1)).thenReturn(image2);

        List<Images> carImages = car.getImages();

        assertEquals(images.size(), carImages.size());
        assertEquals(images.get(0).getImageId(), carImages.get(0).getImageId());
        assertEquals(images.get(0).getUrl(), carImages.get(0).getUrl());
        assertEquals(images.get(1).getImageId(), carImages.get(1).getImageId());
        assertEquals(images.get(1).getUrl(), carImages.get(1).getUrl());
    }

    @Test
    public void testGetId() {
        assertEquals(1L, (long) car.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("Test Car", car.getName());
    }

    @Test
    public void testGetStock() {
        assertEquals(10, car.getStock());
    }

    @Test
    public void testGetStars() {
        assertEquals(4, car.getStars());
    }

    @Test
    public void testGetReviews() {
        assertEquals(2, car.getReviews());
    }

    @Test
    public void testGetImage() {
        assertEquals("test-image.png", car.getImage());
    }

    @Test
    public void testGetFeatured() {
        assertEquals("featured", car.getFeatured());
    }

    @Test
    public void testGetVideoDesc() {
        assertEquals("test-video-desc", car.getVideoDesc());
    }

    @Test
    public void testGetPrice() {
        assertEquals(50000, car.getPrice(), 0.001);
    }

    @Test
    public void testGetDescription() {
        assertEquals("Test description", car.getDescription());
    }

    @Test
    public void testGetCategory() {
        assertEquals("Test category", car.getCategory());
    }

    @Test
    public void testGetCompany() {
        assertEquals("Test company", car.getCompany());
    }

    @Test
    public void testIsDeleted() {
        assertEquals(false, car.isDeleted());
    }
}
