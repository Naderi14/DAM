CREATE PROCEDURE get_available_stays_by_city_dates_guests(
    IN p_city VARCHAR(50),
    IN p_init_date DATE,
    IN p_end_date DATE,
    IN p_min_guests INT
)
BEGIN
SELECT *
FROM stays s1
WHERE (s1.active = TRUE AND s1.num_guests >= p_min_guests AND s1.city LIKE ('%',p_city,'%')) AND s1.id_stay NOT IN (
    SELECT s2.id_stay
    FROM stays s2
             LEFT JOIN bookings b ON s2.id_stay = b.id_stay
    WHERE p_init_date BETWEEN b.init_date AND b.end_date OR
        p_end_date BETWEEN b.init_date AND b.end_date OR
        is_between_interval_dates(p_init_date, p_end_date, b.init_date, b.end_date) = TRUE
);
END;

CREATE FUNCTION is_between_interval_dates(
    IN init_date DATE,
    IN end_date DATE,
    IN interval_init_date DATE,
    IN interval_end_date DATE
)
    RETURNS BOOL
BEGIN
    IF interval_init_date <= init_date AND interval_end_date >= end_date THEN
        RETURN TRUE;
END IF;

RETURN FALSE;
END;