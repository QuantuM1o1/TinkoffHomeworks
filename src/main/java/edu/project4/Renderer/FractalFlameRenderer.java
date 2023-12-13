package edu.project4.Renderer;

import edu.project4.Image.Pixel;
import edu.project4.NonLinearTransformations.NonLinearTransformation;
import java.util.List;

public interface FractalFlameRenderer {
    double XMIN = -1.0;
    double XMAX = 1.0;
    double YMIN = -1.0;
    double YMAX = 1.0;
    int NUMBER_OF_STEPS_TO_SKIP = -20;

    Pixel[][] render(
        int n, int it,
        int xRes, int yRes,
        int count,
        List<NonLinearTransformation> nonLinearTransformations,
        int symmetry
    );




}
