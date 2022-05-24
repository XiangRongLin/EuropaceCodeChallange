# Bowling Game
This solution is done under 2 assumption that were not clarified in the ruleset
- Pins are reset between each frame
- In the last frame no bonus points can be achieved (see example where a spare is achieved, but the 6 points afterwards are not counted as bonus)

Call the program through the CLI by separating frames with a ' ' (space) and rolls within a frame with ','.
The options for the example would be
```
1,4 4,5 6,4 5,5 10 0,1 7,3 6,4 10 2,8,6
```

This was only tested through calling it in IntellIJ and not actually the CLI