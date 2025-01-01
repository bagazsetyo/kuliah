<?php 
// allow memory_limit  
ini_set('memory_limit', -1);
function dd(){
    // get all arguments 
    $args = func_get_args();
    echo "<pre>";
    foreach($args as $arg) {
        print_r($arg);
    }
    echo "</pre>";
    exit;
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
        table {
            border-collapse: collapse;
        }
        td {
            width: 20px;
            height: 20px;
            text-align: center;
        }
        .initial-step {
            display: flex;
            gap: 50px;
        }

        h4 {
            text-align: center;
            font-weight: bold;
        }
        .container-puzzle {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        .finish {
            background-color: green;
        }
        .teble-2 tr td {
            vertical-align: top;
        }
    </style>
</head>
<body>
    Algoritma Pencarian Heuristic pada puzzle 8-puzzle
    <br>
    <br>
    1. Inisialisasi populasi awal secara acak
    <?php
    $goal = array(
        array(1,4,7),
        array(2,5,8),
        array(3,6,'x')
    );

    // random 3x3 
    // $random = array(1,2,3,4,5,6,7,8,'x');
    // shuffle($random);
    // $random = array(1,2,3,4,5,6,7,8,'x');
    // $random = array(1,2,3,4,5,6,7,8,'x');
    $random = array(4,2,1,3,5,6,7,8,'x');
    $random = array_chunk($random, 3);

    ?>
    <br>
    <br>
    <div class="initial-step">
        <div class="container-puzzle">
            <h4>Random 8-puzzle</h4>
            <table>
                <?php foreach($random as $r): ?>
                    <tr>
                    <?php foreach($r as $v): ?>
                        <?php if($v == 'x'): ?>
                            <td style="background-color: black; color: white;"><?php echo $v; ?></td>
                        <?php else: ?>
                            <td><?php echo $v; ?></td>
                        <?php endif; ?>
                    <?php endforeach; ?>
                    </tr>
                <?php endforeach; ?>
            </table>
        </div>
        <div class="container-puzzle">
            <h4>Goal 8-puzzle</h4>
            <table>
                <?php foreach($goal as $r): ?>
                    <tr>
                    <?php foreach($r as $v): ?>
                        <?php if($v == 'x'): ?>
                            <td style="background-color: black; color: white;"><?php echo $v; ?></td>
                        <?php else: ?>
                            <td><?php echo $v; ?></td>
                        <?php endif; ?>
                    <?php endforeach; ?>
                    </tr>
                <?php endforeach; ?>
            </table>
        </div>
    </div>
    <br>
    2. Cari Manhantan Distance
    <br>
    <?php 
        // maping goal 
        function mapPosition($data) {
            $mapGoal = array();
            foreach($data as $i => $r) {
                foreach($r as $j => $v) {
                    $mapGoal[$v] = array($i, $j);
                }
            }

            return $mapGoal;
        }

        function getXposition($random) {
            $xPosition = array(0,0);
            foreach ($random as $i => $subarray) {
                if (($key = array_search('x', $subarray)) !== false) {
                    $xPosition = array($i, $key);
                }
            }

            return $xPosition;
        }

        function getMoveXPosition($xPosition, $direction){
            $newXPosition = $xPosition;
            switch($direction) {
                case 'up':
                    $newXPosition[0] = $xPosition[0] - 1;
                    break;
                case 'down':
                    $newXPosition[0] = $xPosition[0] + 1;
                    break;
                case 'left':
                    $newXPosition[1] = $xPosition[1] - 1;
                    break;
                case 'right':
                    $newXPosition[1] = $xPosition[1] + 1;
                    break;
            }

            return $newXPosition;
        }

        function getMoveAvailable($xPosition, $random) {
            $maxX = count($random[0]);
            $maxY = count($random);

            $moveAvailable = array();
            if($xPosition[0] > 0) {
                $moveAvailable[] = 'up';
            }
            if($xPosition[0] < $maxX - 1) {
                $moveAvailable[] = 'down';
            }
            if($xPosition[1] > 0) {
                $moveAvailable[] = 'left';
            }
            if($xPosition[1] < $maxY - 1) {
                $moveAvailable[] = 'right';
            }

            return $moveAvailable;
        }

        function getDifference($mapGoal, $mapNewRandom) {
            $keysGoal = array_keys($mapGoal);
            $keysNewRandom = array_keys($mapNewRandom);

            $diffCount = 0;
            for ($i = 0; $i < count($keysGoal); $i++) {
                // exclude x position 
                if($keysGoal[$i] == 'x') {
                    continue;
                }
                if($keysGoal[$i] != $keysNewRandom[$i]) {
                    $diffCount++;
                }
            }

            return $diffCount;
        }

        $minHn = 0;
        function manhattanDistance($mapGoal, $random, $positionBefore = array(), $depth = 1) {
            global $minHn;
            $xPosition = getXposition($random);
            $tempMapRamdpm = mapPosition($random);

            $checkisDifferent = getDifference($mapGoal, $tempMapRamdpm);

            if($checkisDifferent == 0) {
                return $random;
            }


            $moveAvailable = getMoveAvailable($xPosition, $random);

            $moveXPosition = array();
            foreach ($moveAvailable as $moveValue) {
                $movePosition = getMoveXPosition($xPosition, $moveValue);

                if(!empty($positionBefore)) {
                    if($movePosition == $positionBefore) {
                        continue;
                    }
                }
                $moveXPosition[$moveValue] = $movePosition;
            }
            // move x position 
            $isFinish = false;
            $newRandom = array();
            foreach($moveXPosition as $direction => $position) {
                $value = $random[$position[0]][$position[1]];
                $tempRandom = $random;
                $tempRandom[$position[0]][$position[1]] = 'x';
                $tempRandom[$xPosition[0]][$xPosition[1]] = $value;

                $newRandom[$direction]['random'] = $tempRandom;

                // formula manhattan distance f(n) = g(n) + h(n)
                $hn_value = 0;
                $mapNewRandom = mapPosition($tempRandom);

                $diffCount = getDifference($mapGoal, $mapNewRandom);

                $hn_value = $diffCount;
                $newRandom[$direction]['hn'] = $hn_value;
                $newRandom[$direction]['gn'] = $depth;
                $newRandom[$direction]['fn'] = $hn_value + $depth;
                $newRandom[$direction]['movePosition'] = $position;
                $newRandom[$direction]['direction'] = $direction;
                $newRandom[$direction]['children'] = array();
                $newRandom[$direction]['depth'] = $depth;
                $newRandom[$direction]['xPosition'] = $xPosition;
            }

            // check hn value
            $hnValue = array_column($newRandom, 'hn');
            $minHn = min($hnValue);

            return $newRandom;

        }

        $mapGoal = mapPosition($goal);
        $manhattanDistance = manhattanDistance($mapGoal, $random);

        $depth = 1;
        $error = 0;
        function getChildrenLoop($manhattanDistanceParent, $mapGoal) {
            global $minHn, $depth, $error;


            if($minHn == 0) {
                return $manhattanDistanceParent;
            }

            $newMinRandom = [];
            foreach ($manhattanDistanceParent as $key => $value) {
                // get depth value 
                if($depth <= 15000){
                    $depth++;
                } else {
                    $error = 1;
                    return $manhattanDistanceParent;
                }

                if($value['hn'] == $minHn) {
                    $manhattanDistance = manhattanDistance($mapGoal, $value['random'], $value['xPosition'], ($value['depth'] + 1));
                    $manhattanDistanceParent[$key]['children'] = $manhattanDistance;

                    // // get min hn value
                    $hnValue = array_column($manhattanDistance, 'hn');
                    $minHn = min($hnValue);

                    // // filter hn with min hn value
                    $newMinRandom = array_filter($manhattanDistance, function($value) use ($minHn) {
                        return $value['hn'] == $minHn;
                    });

                    if(empty($newMinRandom)) {
                        return $manhattanDistanceParent;
                    }

                    // refactoring code foreach 
                    $manhattanDistanceParent[$key]['children'] = getChildrenLoop($manhattanDistanceParent[$key]['children'], $mapGoal, $manhattanDistanceParent, $key);
                }
            }

            return $manhattanDistanceParent;
        }

        if($error == 1){
            echo "Tidak ada solusi";
            exit;
        }
        $manhattanDistance = getChildrenLoop($manhattanDistance, $mapGoal);

        // loop children and make a table 
        function createTableChildren($manhattanDistance){
            $table = '<table class="teble-2" style="width: 100%;">';
            foreach($manhattanDistance as $direction => $value) {
                $table .= '<td>';
                $table .= 'Direction : '.$direction;
                $table .= '<br>';
                $table .= "fn = ".$value['fn']."<br>gn = ".$value['gn']."<br>hn = ".$value['hn'];

                $table .= '<table class="'.($value['hn'] == 0 ? 'finish' : '').'">';
                foreach($value['random'] as $r) {
                    $table .= '<tr>';
                    foreach($r as $v) {
                        if($v == 'x') {
                            $table .= '<td style="background-color: black; color: white;">'.$v.'</td>';
                        } else {
                            $table .= '<td>'.$v.'</td>';
                        }
                    }
                    $table .= '</tr>';
                }
                $table .= '</table>';
                $table .= '<br>';
                $table .= '<br>';
                if(!empty($value['children'])) {
                    $table .= '<h4>Finish</h4>';
                    $table .= '<div style="display: flex; gap: 10px; flex-direction: row;">';
                    $table .= createTableChildren($value['children']);
                    $table .= '</div>';
                }
                $table .= '</td>';
            }
            $table .= '</table>';

            return $table;
        }

        //get list correct path 
        function getCorrectPath($manhattanDistance, $correctPath = array()){
            foreach($manhattanDistance as $direction => $value) {
                if($value['hn'] == 0) {
                    $correctPath[] = [
                        'direction' => $direction,
                        'children' => $value['random'],
                        'fn' => $value['fn'],
                        'gn' => $value['gn'],
                        'hn' => $value['hn']
                    ];
                    return $correctPath;
                }

                if(!empty($value['children'])) {
                    $correctPath[] = [
                        'direction' => $direction,
                        'children' => $value['random'],
                        'fn' => $value['fn'],
                        'gn' => $value['gn'],
                        'hn' => $value['hn']
                    ];

                    $correctPath = getCorrectPath($value['children'], $correctPath);
                }
            }

            // return $correctPath;
            return $correctPath;
        }

        // dd($manhattanDistance);

        $correctPath = getCorrectPath($manhattanDistance);

        // create table for correct path 
        function createTableCorrectPath($correctPath){
            $table = '<table class="teble-2" style="width: 100%;">';
            $chunk = array_chunk($correctPath, 4);
            foreach($chunk as $key => $value) {
                $table .= '<tr>';
                foreach($value as $k => $v) {
                    $table .= '<td>';
                    $table .= '<h4>Step '. ($key * 4 + $k + 1).'</h4>';
                    $table .= 'Direction : '.$v['direction'];
                    $table .= '<br>';
                    $table .= "fn = ".$v['fn']."<br>gn = ".$v['gn']."<br>hn = ".$v['hn'];
                    $table .= '<br>';
                    $table .= '<table class="finish">';
                    foreach($v['children'] as $r) {
                        $table .= '<tr>';
                        foreach($r as $v) {
                            if($v == 'x') {
                                $table .= '<td style="background-color: black; color: white;">'.$v.'</td>';
                            } else {
                                $table .= '<td>'.$v.'</td>';
                            }
                        }
                        $table .= '</tr>';
                    }
                    $table .= '</table>';
                    $table .= '</td>';
                }
                $table .= '</tr>';
            }
            $table .= '</table>';

            return $table;
        }

        echo createTableCorrectPath($correctPath);

        // echo createTableChildren($manhattanDistance);
    ?>
</body>
</html>