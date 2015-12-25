
public class ComputeArea {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	// If there is no overlapping
    	if(C < E || G < A || H < B || D < F)
    		return (C-A)*(D-B) + (G-E)*(H-F);
    	// If there is overlapping
    	int overlapArea = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
    	return (C-A)*(D-B) + (G-E)*(H-F) - overlapArea;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
		System.out.println(computeArea(-3, -3, -2, -2, -2, -2, 2, 2));
		System.out.println(computeArea(0,0,0,0,-1,-1,1,1));
	}

}
