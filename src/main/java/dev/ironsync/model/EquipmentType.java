package dev.ironsync.model;

public enum EquipmentType {

    // --- FREE WEIGHTS ---
    BARBELL,
    DUMBBELL,
    KETTLEBELL,
    WEIGHT_PLATE,        // Plate-only exercises (e.g., Plate Steering Wheels)
    TRAP_BAR,            // Hex Bar (Deadlifts, Shrugs)
    EZ_BAR,              // Bicep/Tricep Curved Bar
    SMITH_MACHINE,       // Guided barbell system

    // --- MACHINES & CABLES ---
    CABLE,               // Adjustable Cable Crossover / Pulley
    MACHINE_SELECTORIZED,// Pin-loaded machines (e.g., Chest Press, Lat Pulldown)
    MACHINE_PLATE_LOADED,// Lever/Plate-loaded machines (e.g., Hammer Strength)
    LEVERAGE_MACHINE,    // Landmine attachment / T-Bar Row setup

    // --- BODYWEIGHT & SUSPENSION ---
    BODYWEIGHT,          // Zero equipment required
    WEIGHTED_BODYWEIGHT, // Bodyweight with added weight (e.g., Weighted Pull-ups)
    SUSPENSION_TRAINER,  // TRX / Gymnastic Rings
    PULL_UP_BAR,         // Fixed overhead bar
    DIP_STATION,          // Parallel bars / Dip station

    // --- BENCHES & RACKS ---
    FLAT_BENCH,
    INCLINE_BENCH,
    DECLINE_BENCH,
    POWER_RACK,          // Squat rack / Power cage
    PREACHER_BENCH,      // Isolated bicep curl station
    HYPEREXTENSION_BENCH,// 45-degree back extension / Roman Chair
    GHD,                 // Glute-Ham Developer

    // --- RESISTANCE & SMALL ACCESSORIES ---
    RESISTANCE_BAND,     // Loop bands / Tube bands
    MINI_BAND,           // Small glute loop bands
    SLANT_BOARD,         // Tibialis / VMO squat board
    AB_WHEEL,            // Abdominal rollout wheel
    PARALLETTES,         // Low push-up bars

    // --- CARDIO & FUNCTIONAL GEAR ---
    MEDICINE_BALL,       // Heavy throw/wall ball
    SLAM_BALL,           // Non-bounce heavy ball
    SANDBAG,             // Functional odd-object training
    BATTLE_ROPES,
    PLYO_BOX,            // Jumpbox
    SLED_PROWLER,        // Push/Pull turf sled

    // --- CABLE ATTACHMENTS (for exercise specificity) ---
    CABLE_ROPE,          // Tricep rope / Facepull attachment
    CABLE_V_BAR,         // V-handle attachment
    CABLE_STRAIGHT_BAR,  // Wide or short straight bar
    CABLE_SINGLE_HANDLE, // D-handle
    ANKLE_STRAP          // Cable leg attachment
}
