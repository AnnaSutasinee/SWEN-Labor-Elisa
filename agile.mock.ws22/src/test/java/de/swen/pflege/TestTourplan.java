package de.swen.pflege;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestTourplan {

	// TEST TASK 1

	@Test(timeout = 1000)
	public void testConstructorNameLengthThree() {
		String name = new String();
		for (int i = 0; i < 3; i++) {
			name += "A";
		}
		Tourplan out = new Tourplan(name, new CentralClientFinder(), new SapService());
		assertEquals(name, out.getName());
	}

	@Test(timeout = 1000)
	public void testConstructorNameLengthThirtyone() {
		String name = new String();
		for (int i = 0; i < 31; i++) {
			name += "A";
		}
		Tourplan out = new Tourplan(name, new CentralClientFinder(), new SapService());
		assertEquals(name, out.getName());
	}

	@Test(timeout = 1000, expected = IllegalArgumentException.class)
	public void testConstructorNameNull() {
		new Tourplan(null, new CentralClientFinder(), new SapService());
	}

	@Test(timeout = 1000, expected = IllegalArgumentException.class)
	public void testConstructorNameLengthTwo() {
		String name = new String();
		for (int i = 0; i < 2; i++) {
			name += "A";
		}
		new Tourplan(name, new CentralClientFinder(), new SapService());
	}

	@Test(timeout = 1000, expected = IllegalArgumentException.class)
	public void testConstructorNameLengthThirtytwo() {
		String name = new String();
		for (int i = 0; i < 32; i++) {
			name += "A";
		}
		new Tourplan(name, new CentralClientFinder(), new SapService());
	}

}
