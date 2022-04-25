package no.arnemunthekaas.gameproject.levels.wfc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WFCnode {
	
	public int tileamount;
	public int x;
	public int y;
	public List<WFCnode> neighbors = new ArrayList<WFCnode>();
	public int tile = -1;
	
	public boolean collapsed;
	
	public int propnum;
	
	
	public WFCnode(int tileamount, int x, int y) {
		this.tileamount = tileamount;
		this.propnum = 5;
		this.x = x;
		this.y = y;
	}
	
	private void genTile() {
		if(tile != -1) {
			return;
		}
		
		Random random = new Random();
		
		List<Integer> neighborTiles = neighbors.stream().map(n -> n.tile).filter(i -> i != -1).collect(Collectors.toList());
		neighborTiles.sort((i1, i2) -> Integer.compare(i1, i2));
		
		int max = neighborTiles.get(0);
		int min = neighborTiles.get(neighborTiles.size()-1);
		
		if(max == min)
			tile = max + random.nextInt(3)-1;
		else if(max - min == 1)
			tile = max - random.nextInt(2);
		else {
			tile = (max + min) / 2;
		}
		if (tile > tileamount-1)
			tile = tileamount-1;
		
		if (tile < 0)
			tile = 0;
		
	}
	
	public void propagate() {
		if(collapsed)
			return;
		
		collapsed = true;
		
		for(WFCnode neighbor : neighbors) {
			if(neighbor.x == x || neighbor.y == y) {
				neighbor.propnum -= 2;
			} else {
				neighbor.propnum--;
			}
		}
		
		
		
		
		this.genTile();

		neighbors.sort((n, n2) -> Integer.compare(n2.propnum, n.propnum));
		
		neighbors.forEach(n -> n.propagate());
		
	}
	
	

}
